package com.wanted.spendtracker.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBudget is a Querydsl query type for Budget
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBudget extends EntityPathBase<Budget> {

    private static final long serialVersionUID = 1478299245L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBudget budget = new QBudget("budget");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final QCategory category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QBudget(String variable) {
        this(Budget.class, forVariable(variable), INITS);
    }

    public QBudget(Path<? extends Budget> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBudget(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBudget(PathMetadata metadata, PathInits inits) {
        this(Budget.class, metadata, inits);
    }

    public QBudget(Class<? extends Budget> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

