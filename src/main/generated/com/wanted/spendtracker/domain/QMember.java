package com.wanted.spendtracker.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1778706882L;

    public static final QMember member = new QMember("member1");

    public final StringPath accountName = createString("accountName");

    public final ListPath<Budget, QBudget> budgets = this.<Budget, QBudget>createList("budgets", Budget.class, QBudget.class, PathInits.DIRECT2);

    public final ListPath<Expenses, QExpenses> expenses = this.<Expenses, QExpenses>createList("expenses", Expenses.class, QExpenses.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

