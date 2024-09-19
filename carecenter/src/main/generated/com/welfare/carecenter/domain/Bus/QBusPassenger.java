package com.welfare.carecenter.domain.Bus;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBusPassenger is a Querydsl query type for BusPassenger
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusPassenger extends EntityPathBase<BusPassenger> {

    private static final long serialVersionUID = 447364793L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBusPassenger busPassenger = new QBusPassenger("busPassenger");

    public final StringPath busAvgTime = createString("busAvgTime");

    public final StringPath busCallTiming = createString("busCallTiming");

    public final NumberPath<Integer> busPassengerId = createNumber("busPassengerId", Integer.class);

    public final StringPath busPassengerName = createString("busPassengerName");

    public final QBusPickupInformation busPickupInformation;

    public final StringPath busStatus = createString("busStatus");

    public QBusPassenger(String variable) {
        this(BusPassenger.class, forVariable(variable), INITS);
    }

    public QBusPassenger(Path<? extends BusPassenger> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBusPassenger(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBusPassenger(PathMetadata metadata, PathInits inits) {
        this(BusPassenger.class, metadata, inits);
    }

    public QBusPassenger(Class<? extends BusPassenger> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.busPickupInformation = inits.isInitialized("busPickupInformation") ? new QBusPickupInformation(forProperty("busPickupInformation")) : null;
    }

}

