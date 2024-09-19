package com.welfare.carecenter.domain.User;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPatientAbsence is a Querydsl query type for PatientAbsence
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPatientAbsence extends EntityPathBase<PatientAbsence> {

    private static final long serialVersionUID = 316604042L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPatientAbsence patientAbsence = new QPatientAbsence("patientAbsence");

    public final StringPath absenceDate = createString("absenceDate");

    public final NumberPath<Integer> absenceId = createNumber("absenceId", Integer.class);

    public final QPatient patient;

    public QPatientAbsence(String variable) {
        this(PatientAbsence.class, forVariable(variable), INITS);
    }

    public QPatientAbsence(Path<? extends PatientAbsence> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPatientAbsence(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPatientAbsence(PathMetadata metadata, PathInits inits) {
        this(PatientAbsence.class, metadata, inits);
    }

    public QPatientAbsence(Class<? extends PatientAbsence> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.patient = inits.isInitialized("patient") ? new QPatient(forProperty("patient")) : null;
    }

}

