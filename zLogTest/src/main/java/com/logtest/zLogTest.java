package com.logtest;


import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by eSumit on 5th-Feb-2018.
 */
public class zLogTest implements RequestStreamHandler {

    // Initialize the Log4j logger.
    static final Logger log = Logger.getLogger(zLogTest.class);

    private int invocations = 0;

    public void  handleRequest(InputStream input, OutputStream output, Context context) {


        for(int x = 0; x<5; x++) {
            invocations++;

            System.out.println("invocations = " + invocations);
        }

        // System.out: One log statement but with a line break (AWS Lambda writes two events to CloudWatch).
        System.out.println("log data from stdout \n this is continuation of system.out");

        // System.err: One log statement but with a line break (AWS Lambda writes two events to CloudWatch).
        System.err.println("log data from stderr. \n this is a continuation of system.err");

        // Use log4j to log the same thing as above and AWS Lambda will log only one event in CloudWatch.
        log.debug("log data from log4j debug \n this is continuation of log4j debug");

        log.error("log data from log4j err. \n this is a continuation of log4j.err");

        log.info("log data from log4j info. \n this is a continuation of log4j.info");

        log.fatal("log data from log4j fatal. \n this is a continuation of log4j.fatal");

        System.out.println("log.getLevel() : " + log.getLevel());

        System.out.println("log.getAdditivity(): " + log.getAdditivity());

        System.out.println("log.getAllAppenders(): " + log.getAllAppenders());

        System.out.println("log.getEffectiveLevel(): "+ log.getEffectiveLevel());

        System.out.println("log.getLoggerRepository(): "+ log.getLoggerRepository());

        System.out.println("log.getName(): "+ log.getName());

        System.out.println("log.getParent(): "+ log.getParent());

        System.out.println("log.getResourceBundle(): "+ log.getResourceBundle());

        System.out.println("log.getClass(): "+log.getClass());

        System.out.println("Funcion got finished ");

    }

}
