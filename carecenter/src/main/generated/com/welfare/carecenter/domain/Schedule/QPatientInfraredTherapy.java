package com.welfare.carecenter.domain.Schedule;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPatientInfraredTherapy is a Querydsl query type for PatientInfraredTherapy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPatientInfraredTherapy extends EntityPathBase<PatientInfraredTherapy> {

    private static final long serialVersionUID = 1444276201L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPatientInfraredTherapy patientInfraredTherapy = new QPatientInfraredTherapy("patientInfraredTherapy");

    public final com.welfare.carecenter.domain.User.QPatient patient;

    public final StringPath patientTreatmentDate = createString("patientTreatmentDate");

    public final NumberPath<Integer> therapyListId = createNumber("therapyListId", Integer.class);

    public QPatientInfraredTherapy(String variable) {
        this(PatientInfraredTherapy.class, forVariable(variable), INITS);
    }

    public QPatientInfraredTherapy(Path<? extends PatientInfraredTherapy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPatientInfraredTherapy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPatientInfraredTherapy(PathMetadata metadata, PathInits inits) {
        this(PatientInfraredTherapy.class, metadata, inits);
    }

    public QPatientInfraredTherapy(Class<? extends PatientInfraredTherapy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.patient = inits.isInitialized("patient") ? new com.welfare.carecenter.domain.User.QPatient(forProperty("patient")) : null;
    }

}

