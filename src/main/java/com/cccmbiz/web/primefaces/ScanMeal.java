package com.cccmbiz.web.primefaces;

import com.cccmbiz.api.MealPickUpRecords;
import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.services.RegMealService;
import com.cccmbiz.web.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

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

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List getMealtrackers() {
        return this.mealtrackers;
    }

    public String enter() throws ScanMealException {

        reset();

        if (query != null && !query.isEmpty()) {

            FacesContext context = FacesContext.getCurrentInstance();

            try {

                Integer personId = Integer.parseInt(query);

                MealScanResponse mealRecord = regMealService.scanMeal(personId);
                // Obtain current time
                DateTime now = DateTime.now();
                Timestamp ts = new Timestamp(now.getMillis());

                Integer mealTotal = mealRecord.getMealOrdered();

                if (mealTotal == 0) {
                    logger.info("No Order Record");

                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "沒有订餐记录。"));
                } else if (mealTotal <= mealRecord.getMealTaken()) {
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
                    Date parsedDate = dateFormat.parse(rec.getPickUpDate());
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
            } catch (ParseException parseError) {
                logger.error("Scan Error:" + parseError.getMessage());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "系統问題"));
            } finally {
                query = "";
            }
        }

        return "success";
    }


    private void reset() {
        if (mealtrackers != null) {
            mealtrackers.clear();
        }
        mealTotalCount = "";
        mealTakenCount = "";
        mealLeftCount = "";
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
