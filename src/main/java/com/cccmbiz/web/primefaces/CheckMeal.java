package com.cccmbiz.web.primefaces;

import com.cccmbiz.api.MealPickUpRecords;
import com.cccmbiz.api.MealPlansStatus;
import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.api.MealStatusResponse;
import com.cccmbiz.services.RegMealService;
import com.cccmbiz.web.MealTracker;
import com.cccmbiz.web.ScanMealException;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Named
@RequestScope
public class CheckMeal {

    private static final Logger logger = LoggerFactory.getLogger(CheckMeal.class);

    @Autowired
    private RegMealService regMealService;

    private List<MealPlansStatus> mealPlans;

    private List<MealPickUpRecords> pickUpRecords;

    private Integer mealId;

    private Map<String, Integer> mealIdOption = new HashMap<String, Integer>();

    public Map<String, Integer> getMealIdOption() {
        return mealIdOption;
    }

    private String query;

    @PostConstruct
    public void init() {

        // Meal Id option
        mealIdOption.put("DINNER TUE 12/28 ", 29);
        mealIdOption.put("BREAKFAST WED 12/29", 32);
        mealIdOption.put("LUNCH WED 12/29", 35);
        mealIdOption.put("DINNER WED 12/29", 30);
        mealIdOption.put("BREAKFAST THU 12/30", 33);
        mealIdOption.put("LUNCH THU 12/30", 36);
        mealIdOption.put("DINNER THU 12/30", 31);
        mealIdOption.put("BREAKFAST FRI 12/31", 34);
        mealIdOption.put("LUNCH FRI 12/31", 37);

    }


    public List<MealPlansStatus> getMealPlans() {
        return mealPlans;
    }

    public List<MealPickUpRecords> getPickUpRecords(Integer mealId) {

        logger.debug("Meal ID: " + mealId);

//        for (MealPlansStatus mps : this.mealPlans) {
//            logger.debug("Compare " + mps.getMealId());
//            if (mps.getMealId().compareTo(mealId) == 0) {
//                return mps.getPickUpRecord();
//            }
//        }
        return new ArrayList<>();
    }


    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void enter() throws ScanMealException, ParseException {

        reset();

        if (query != null && !query.isEmpty()) {

            FacesContext context = FacesContext.getCurrentInstance();

            try {

                String scannedId = query;

                MealStatusResponse mealRecord = regMealService.checkMeal(scannedId);

                for (MealPlansStatus st : mealRecord.getMealPlans()) {
                    logger.info(st.getDescription());
                    logger.info("pick up count:" + st.getPickUpRecord().size());
                    for (MealPickUpRecords rec : st.getPickUpRecord()) {
                        logger.info("pickup person ID: \"" + rec.getPersonId() + "\"");
                        logger.info("pickup person name: " + rec.getName());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
                        Date parsedDate = rec.getPickUpDate();
                        logger.info("pickup person date: " + parsedDate.toString());
                        logger.info("------------------------------------------------------------");
                    }
                }

                if (mealPlans == null) {
                    mealPlans = new ArrayList<>();
                }
                mealPlans.addAll(mealRecord.getMealPlans());

                if (mealPlans.size() == 0) {
                    logger.info("No Order Record");

                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "沒有订餐记录。"));
                } else {

                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "成动! ", "此是订餐记录。"));

                }

//                for (MealPickUpRecords rec: mealRecord.getMealPlans().getPickUpRecord()) {
//                    MealTracker mt = new MealTracker();
//                    logger.info("\"" + rec.getPickUpDate() + "\"");
//                    logger.info(rec.getName());
//                    // 2019-11-01T00:48:45.984-05:00
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
//                    Date parsedDate = dateFormat.parse(rec.getPickUpDate());
//                    mt.setPickUpDate(new Timestamp(parsedDate.getTime()));
//                    mt.setName(rec.getName());
//
//                    mealtrackers.add(mt) ;
//                }

            } catch (NoSuchElementException noSuchElementException) {
                logger.error("Check Error:" + noSuchElementException.getMessage());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "没有这个注册记录"));
            } catch (NumberFormatException numberFormatException) {
                logger.error("Check Error:" + numberFormatException.getMessage());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "請輸入正確注册号码"));
            } catch (ScanMealException scanMealException) {
                logger.error("Scan Error:" + scanMealException.getMessage());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "系統问題"));
            } finally {
                query = "";
            }
        }

    }


    private void reset() {
        if (mealPlans != null) {
            mealPlans.clear();
        }
    }


}
