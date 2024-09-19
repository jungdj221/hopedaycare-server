package com.welfare.carecenter.domain.Bus;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBusPickupInformation is a Querydsl query type for BusPickupInformation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusPickupInformation extends EntityPathBase<BusPickupInformation> {

    private static final long serialVersionUID = 1774667823L;

    public static final QBusPickupInformation busPickupInformation = new QBusPickupInformation("busPickupInformation");

    public final StringPath busDriver = createString("busDriver");

    public final StringPath busHelper = createString("busHelper");

    public final NumberPath<Integer> busId = createNumber("busId", Integer.class);

    public final NumberPath<Integer> busNumber = createNumber("busNumber", Integer.class);

    public final StringPath busSubDriver = createString("busSubDriver");

    public final StringPath busSubHelper = createString("busSubHelper");

    public final StringPath busVehicleName = createString("busVehicleName");

    public QBusPickupInformation(String variable) {
        super(BusPickupInformation.class, forVariable(variable));
    }

    public QBusPickupInformation(Path<? extends BusPickupInformation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBusPickupInformation(PathMetadata metadata) {
        super(BusPickupInformation.class, metadata);
    }

}

