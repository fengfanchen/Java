package cn.it1995.demo.config;

import cn.it1995.demo.job.QuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail job(){

        return JobBuilder.newJob(QuartzJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger(){

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/30 * * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(job())
                .withSchedule(scheduleBuilder)
                .build();
    }
}
