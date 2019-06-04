package com.cccmbiz.web.primefaces;

import com.cccmbiz.web.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ws.cccm.reg.service.NameTag;
import ws.cccm.reg.service.NameTagService;
import ws.cccm.reg.service.NameTagServiceImpl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Named
@Scope("request")
public class Operation {

    private static final Logger logger = LoggerFactory.getLogger(Operation.class);

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ChurchRepository churchRepository;


    private String queryId;

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String printNametag() {

        logger.debug("Input parameter:" + queryId);



        Set<NameTag> printRequest = new LinkedHashSet<>();

        try {

            String rid = queryId ;

//            if (personRepository.existsById(Integer.valueOf(queryId))) {
//                Person ps = personRepository.findById(Integer.valueOf(queryId)).get() ;
//                rid = ps.getFamilyId().toString();
//            }

            List<Person> personList = personRepository.findByFamilyId(Integer.parseInt(rid));

            for (Person person : personList) {

                NameTag nameTag = new NameTag();

                nameTag.setConferenceName("二零一八基督徒大會");

                if (person.getChineseName() != null && !person.getChineseName().isEmpty()) {
                    nameTag.setChineseFullName(person.getChineseName());
                } else {
                    nameTag.setChineseFullName(person.getFirstName());
                }

                logger.info("Name:" + nameTag.getChineseFullName());
                nameTag.setEnglishFullName(person.getFirstName() + " " + person.getLastName());

                if (person.getChurchId() != null && churchRepository.existsById(person.getChurchId())) {

                    Church church = churchRepository.findById(person.getChurchId()).get();
                    nameTag.setChruchName(church.getChurchNameChn());
                } else {
                    nameTag.setChruchName("");
                }

                nameTag.setCenterId(String.valueOf(person.getFamilyId()));

                String groupID = (person.getHealthCardNo() == null ? "" : person.getHealthCardNo());
                nameTag.setGroupId(groupID);
                nameTag.setBarcodeId(String.valueOf(person.getPersonId()));

                if (profileRepository.existsById(person.getPersonId())) {

                    Profile profile = profileRepository.findById(person.getPersonId()).get();

                    String topic = "";
                    if (profile.getWorkshop1() != null && !profile.getWorkshop1().isEmpty()) {
                        String[] list = profile.getWorkshop1().split("\\|");
                        for (String wt : list) {
                            if (wt != null && !wt.isEmpty()) {
                                if (!topic.isEmpty()) {
                                    topic += ",";
                                }
                                topic += wt;
                            }
                        }
                    }
                    if (profile.getWorkshop2() != null && !profile.getWorkshop2().isEmpty()) {
                        String[] list = profile.getWorkshop2().split("\\|");
                        for (String st : list) {
                            if (st != null && !st.isEmpty()) {
                                if (!topic.isEmpty()) {
                                    topic += ",";
                                }
                                topic += st;
                            }
                        }
                    }
                    nameTag.setTopic(topic);
                }
                printRequest.add(nameTag);
            }

            NameTagService nameTagService = new NameTagServiceImpl();
            byte[] pdf = nameTagService.generateNameTagPrints(printRequest, 2);


            HttpServletResponse response
                    = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=nametag-" + rid  + ".pdf");
            response.getOutputStream().write(pdf);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().responseComplete();

        } catch (Exception exception) {
            logger.error(exception.getMessage());
            exception.printStackTrace();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", exception.getMessage()));

        }

        return "success";

    }
}
