package com.welfare.carecenter.domain.User;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPatient is a Querydsl query type for Patient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPatient extends EntityPathBase<Patient> {

    private static final long serialVersionUID = 1935379507L;

    public static final QPatient patient = new QPatient("patient");

    public final StringPath patientGraduationDate = createString("patientGraduationDate");

    public final NumberPath<Integer> patientId = createNumber("patientId", Integer.class);

    public final StringPath patientInfo = createString("patientInfo");

    public final StringPath patientName = createString("patientName");

    public final StringPath patientStatus = createString("patientStatus");

    public QPatient(String variable) {
        super(Patient.class, forVariable(variable));
    }

    public QPatient(Path<? extends Patient> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPatient(PathMetadata metadata) {
        super(Patient.class, metadata);
    }

}

