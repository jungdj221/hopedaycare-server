package com.welfare.carecenter.domain.Schedule;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPatientAirMassage is a Querydsl query type for PatientAirMassage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPatientAirMassage extends EntityPathBase<PatientAirMassage> {

    private static final long serialVersionUID = -1326144320L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPatientAirMassage patientAirMassage = new QPatientAirMassage("patientAirMassage");

    public final NumberPath<Integer> massageListId = createNumber("massageListId", Integer.class);

    public final com.welfare.carecenter.domain.User.QPatient patient;

    public final StringPath patientTreatmentDate = createString("patientTreatmentDate");

    public QPatientAirMassage(String variable) {
        this(PatientAirMassage.class, forVariable(variable), INITS);
    }

    public QPatientAirMassage(Path<? extends PatientAirMassage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPatientAirMassage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPatientAirMassage(PathMetadata metadata, PathInits inits) {
        this(PatientAirMassage.class, metadata, inits);
    }

    public QPatientAirMassage(Class<? extends PatientAirMassage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.patient = inits.isInitialized("patient") ? new com.welfare.carecenter.domain.User.QPatient(forProperty("patient")) : null;
    }

}

