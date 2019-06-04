package com.cccmbiz.web.primefaces;

import com.cccmbiz.web.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class Dangerous {

    private static final Logger logger = LoggerFactory.getLogger(Dangerous.class);

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MealplanRepository mealplanRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    private String dangerousId;

    public String getDangerousId() {
        return dangerousId;
    }

    public void setDangerousId(String dangerousId) {
        this.dangerousId = dangerousId;
    }

    public String deleteEntire() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (dangerousId == null || dangerousId.isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "Please provide input"));
        }

        StringBuilder sb = new StringBuilder() ;

        try {

            Integer rid = Integer.parseInt(dangerousId) ;

            logger.debug("Input parameter:" + rid);

            Optional<Family> fopt = familyRepository.findById(rid);

            if (fopt.isPresent()) {
                Family family = fopt.get();

                List<Person> personList = personRepository.findByFamilyId(rid); //result returned from some method.
                for (Person p : personList) {
                    logger.debug("Deleting " + p.getChineseName() + " " + p.getFirstName() + " " + p.getLastName() + "...");
                    Integer pid = p.getPersonId();
                    personRepository.delete(p);
                    sb.append("Delete registration of " + p.getChineseName() + " " + p.getFirstName() + " " + p.getLastName() + "\n");
                    if (profileRepository.existsById(pid)) {
                        profileRepository.deleteById(pid);
                        sb.append("Delete profile of " + p.getChineseName() + " " + p.getFirstName() + " " + p.getLastName() + "\n");
                    }


                }
                Long fid = rid.longValue();

                List<Payment> paymentList = paymentRepository.findByRegistrationId(fid);
                for (Payment payment : paymentList) {
                    paymentRepository.delete(payment);
                    sb.append("Delete payment info (" + payment.getId()+ ") Amount paid : " + (payment.getAmount() != null ? payment.getAmount() : 0 ) + "\n");
                }
                if (mealplanRepository.existsById(dangerousId)) {
                    mealplanRepository.deleteById(dangerousId);
                    sb.append("Delete meal plan (" + fid + ")  \n");
                }

                familyRepository.delete(family);

                if (! familyRepository.existsById(rid)) {
                    sb.append("Delete family (" + fid + ")  \n");
                }
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "抱歉! ", "No record about " + dangerousId));
            }
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", exception.getMessage()));
            exception.printStackTrace();
            return "operation";
        }

        logger.debug("Success message:" + sb.toString());
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!  ", sb.toString()));

        return "success" ;
    }


}
