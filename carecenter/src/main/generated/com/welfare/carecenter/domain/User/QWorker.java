package com.welfare.carecenter.domain.User;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorker is a Querydsl query type for Worker
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWorker extends EntityPathBase<Worker> {

    private static final long serialVersionUID = -1387376L;

    public static final QWorker worker = new QWorker("worker");

    public final NumberPath<Integer> workerId = createNumber("workerId", Integer.class);

    public final StringPath workerInfo = createString("workerInfo");

    public final StringPath workerName = createString("workerName");

    public final StringPath workerRoll = createString("workerRoll");

    public QWorker(String variable) {
        super(Worker.class, forVariable(variable));
    }

    public QWorker(Path<? extends Worker> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorker(PathMetadata metadata) {
        super(Worker.class, metadata);
    }

}

