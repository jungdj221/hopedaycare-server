package com.welfare.carecenter.domain.Bus;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBusSeats is a Querydsl query type for BusSeats
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusSeats extends EntityPathBase<BusSeats> {

    private static final long serialVersionUID = -460405587L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBusSeats busSeats = new QBusSeats("busSeats");

    public final QBusPickupInformation busPickupInformation;

    public final NumberPath<Integer> busSeatId = createNumber("busSeatId", Integer.class);

    public final StringPath busSeatStatus = createString("busSeatStatus");

    public QBusSeats(String variable) {
        this(BusSeats.class, forVariable(variable), INITS);
    }

    public QBusSeats(Path<? extends BusSeats> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBusSeats(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBusSeats(PathMetadata metadata, PathInits inits) {
        this(BusSeats.class, metadata, inits);
    }

    public QBusSeats(Class<? extends BusSeats> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.busPickupInformation = inits.isInitialized("busPickupInformation") ? new QBusPickupInformation(forProperty("busPickupInformation")) : null;
    }

}

