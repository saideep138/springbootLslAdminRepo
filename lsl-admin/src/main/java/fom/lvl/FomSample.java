package fom.lvl;

import org.springframework.stereotype.Component;

@Component
public class FomSample {

}
/*
 Hibernate: create table customerinfo (cusid bigint not null, age bigint, cus_name varchar(255), gender varchar(255), mobileno varchar(255), primary key (cusid)) engine=InnoDB
Hibernate: create table customerinfo_seq (next_val bigint) engine=InnoDB
Hibernate: insert into customerinfo_seq values ( 1 )
Hibernate: create table paymentdetails (payid bigint not null, amount bigint, paytype varchar(255), primary key (payid)) engine=InnoDB
Hibernate: create table paymentdetails_seq (next_val bigint) engine=InnoDB
Hibernate: insert into paymentdetails_seq values ( 1 )
Hibernate: create table tripinfo (trip_id bigint not null, travel_date datetime(6), cusid bigint, flightid bigint, payid bigint, primary key (trip_id)) engine=InnoDB
Hibernate: create table tripinfo_seq (next_val bigint) engine=InnoDB
Hibernate: insert into tripinfo_seq values ( 1 )
 
 */