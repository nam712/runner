//package com.sCore.modules.schedule;
//
//import com.sCore.core.utils.CommonUtil;
//import com.sCore.modules.scoreMng.bo.Classroom;
//import com.sCore.modules.scoreMng.dao.ClassroomDAO;
//import com.sCore.modules.scoreMng.service.ClassroomService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class ScheduleService {
//    public static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);
//
//    @Scheduled(cron = "${cron.classroomStatusScheduled}")
//    public void updateClassroomSchedule() {
//        LOGGER.info("--- updateClassroomSchedule ---");
//        try {
//
//        } catch (Exception ex) {
//            LOGGER.error(ex.toString());
//        }
//
//    }
//
//    @Scheduled(cron = "${cron.endCourseScheduled}")
//    public void endCourseScheduled() {
//        LOGGER.info("--- endCourseScheduled ---");
//        try {
//
//        } catch (Exception ex) {
//            LOGGER.error(ex.toString());
//        }
//    }
//}
