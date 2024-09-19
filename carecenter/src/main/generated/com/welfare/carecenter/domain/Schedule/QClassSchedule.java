package com.welfare.carecenter.domain.Schedule;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassSchedule is a Querydsl query type for ClassSchedule
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClassSchedule extends EntityPathBase<ClassSchedule> {

    private static final long serialVersionUID = 1315422249L;

    public static final QClassSchedule classSchedule = new QClassSchedule("classSchedule");

    public final StringPath scheduleBegin = createString("scheduleBegin");

    public final StringPath scheduleDate = createString("scheduleDate");

    public final StringPath scheduleEnd = createString("scheduleEnd");

    public final NumberPath<Integer> scheduleId = createNumber("scheduleId", Integer.class);

    public final StringPath scheduleInfo = createString("scheduleInfo");

    public final StringPath scheduleName = createString("scheduleName");

    public QClassSchedule(String variable) {
        super(ClassSchedule.class, forVariable(variable));
    }

    public QClassSchedule(Path<? extends ClassSchedule> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassSchedule(PathMetadata metadata) {
        super(ClassSchedule.class, metadata);
    }

}

