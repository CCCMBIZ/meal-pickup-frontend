package com.cccmbiz.web.primefaces;

import com.cccmbiz.api.MealInfoResponse;
import com.cccmbiz.api.MealPickUpRecords;
import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.api.MealStatusResponse;
import com.cccmbiz.domain.Meal;
import com.cccmbiz.services.RegMealService;
import com.cccmbiz.web.*;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
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
public class ScanMeal {

    private static final Logger logger = LoggerFactory.getLogger(ScanMeal.class);

    @Autowired
    private RegMealService regMealService;

    private List mealtrackers;
    private String query;

    private String mealTotalCount;
    private String mealTakenCount;
    private String mealLeftCount;

    private Integer mealId;
    private Map<String, Integer> mealIdOption = new HashMap<String, Integer>();

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Map<String, Integer> getMealIdOption() {
        return mealIdOption;
    }

    @PostConstruct
    public void init() {

        // Obtain current time
        DateTime now = DateTime.now();
        // Initial meal Id
        mealId = getMealIDByTime(now);

        // Meal Id option
        mealIdOption.put("DINNER WED 12/28", 39);
        mealIdOption.put("BREAKFAST THU 12/29", 42);
        mealIdOption.put("LUNCH THU 12/29", 45);
        mealIdOption.put("DINNER THU 12/29", 40);
        mealIdOption.put("BREAKFAST FRI 12/30", 43);
        mealIdOption.put("LUNCH FRI 12/30", 46);
        mealIdOption.put("DINNER FRI 12/30", 41);
        mealIdOption.put("BREAKFAST SAT 12/31", 44);
        mealIdOption.put("LUNCH SAT 12/31", 47);

    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List getMealtrackers() {
        return this.mealtrackers;
    }

    public void enter() throws ScanMealException {

        reset();

        if (query != null && !query.isEmpty()) {

            FacesContext context = FacesContext.getCurrentInstance();

            try {

                String scannedId = query;

                logger.debug("Scanned ID: " + scannedId + " Meal ID: " + mealId);

                MealScanResponse mealRecord = regMealService.scanMeal(scannedId, mealId);
                // Obtain current time
                DateTime now = DateTime.now();
                Timestamp ts = new Timestamp(now.getMillis());

                Integer mealTotal = mealRecord.getMealOrdered();

                if (mealTotal == 0) {
                    logger.info("No Order Record");

                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "沒有订餐记录。"));
                } else if (mealTotal <= mealRecord.getMealTaken() && mealRecord.getMealStatus() == 1) {
                    logger.info("Exceed Order Count");

                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "抱歉! ", "己領了全部的饭盒。"));
                } else {

                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "成动! ", "请拿饭盒。"));

                }

                if (mealtrackers == null) {
                    mealtrackers = new ArrayList<MealTracker>();
                }
                for (MealPickUpRecords rec : mealRecord.getPickUpRecord()) {
                    MealTracker mt = new MealTracker();
                    logger.info("\"" + rec.getPickUpDate() + "\"");
                    logger.info(rec.getName());
                    // 2019-11-01T00:48:45.984-05:00
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
                    Date parsedDate = rec.getPickUpDate();
                    mt.setPickUpDate(new java.sql.Timestamp(parsedDate.getTime()));
                    mt.setName(rec.getName());

                    mealtrackers.add(mt);
                }

                mealTotalCount = new StringBuilder()
                        .append("订了 ")
                        .append(mealRecord.getMealOrdered())
                        .toString();

                mealTakenCount = new StringBuilder()
                        .append("領了 ")
                        .append(mealRecord.getMealTaken())
                        .toString();

                StringBuilder sb = new StringBuilder();
                sb.append("剩下  ");
                sb.append(mealRecord.getMealRemaining());
                mealLeftCount = sb.toString();


            } catch (NoSuchElementException noSuchElementException) {
                logger.error("Scan Error:" + noSuchElementException.getMessage());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "没有这个注册记录"));
            } catch (NumberFormatException numberFormatException) {
                logger.error("Scan Error:" + numberFormatException.getMessage());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "請輸入正確注册号码"));
            } catch (ScanMealException scamMealException) {
                logger.error("Scan Error:" + scamMealException.getMessage());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "系統问題.不能連上服务器"));
//            } catch (ParseException parseError) {
//                logger.error("Scan Error:" + parseError.getMessage());
//                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "系統问題"));
            } finally {
                query = "";
            }
        }

    }


    private void reset() {
        if (mealtrackers != null) {
            mealtrackers.clear();
        }
        mealTotalCount = "";
        mealTakenCount = "";
        mealLeftCount = "";
    }

    public Integer getMealIDByTime(DateTime mealTime) {

        try {
            MealInfoResponse mealResponse = regMealService.getMeals(1);

            List<Meal> meals = mealResponse.getMeals();

            for (Meal m : meals) {
                LocalDate ld = LocalDate.fromDateFields(m.getDate());
                LocalTime st = new LocalTime(m.getStartTime());
                LocalTime et = new LocalTime(m.getEndTime());

                Interval interval = new Interval(ld.toDateTime(st), ld.toDateTime(et));

                if (interval.contains(mealTime) || interval.getEnd().isEqual(mealTime)) {
                    logger.info("Found Meal ID : " + m.getId());
                    return m.getId();
                }
            }

        } catch (ScanMealException e) {
            logger.error("Error getting meal time - " + e.getMessage());
        }
        return 0;
    }

    /**
     * @return the mealTotalCount
     */
    public String getMealTotalCount() {
        return mealTotalCount;
    }

    /**
     * @return the mealTakenCount
     */
    public String getMealTakenCount() {
        return mealTakenCount;
    }

    /**
     * @return the mealLeftCount
     */
    public String getMealLeftCount() {
        return mealLeftCount;
    }

}
