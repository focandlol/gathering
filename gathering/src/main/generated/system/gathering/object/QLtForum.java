package system.gathering.object;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLtForum is a Querydsl query type for LtForum
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLtForum extends EntityPathBase<LtForum> {

    private static final long serialVersionUID = 1126349904L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLtForum ltForum = new QLtForum("ltForum");

    public final StringPath address = createString("address");

    public final EnumPath<Category> category = createEnum("category", Category.class);

    public final StringPath content = createString("content");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final StringPath detailAddress = createString("detailAddress");

    public final StringPath extraAddress = createString("extraAddress");

    public final NumberPath<Long> forumId = createNumber("forumId", Long.class);

    public final QUser host;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final StringPath postcode = createString("postcode");

    public final StringPath startTime = createString("startTime");

    public final StringPath state = createString("state");

    public final StringPath subject = createString("subject");

    public QLtForum(String variable) {
        this(LtForum.class, forVariable(variable), INITS);
    }

    public QLtForum(Path<? extends LtForum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLtForum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLtForum(PathMetadata metadata, PathInits inits) {
        this(LtForum.class, metadata, inits);
    }

    public QLtForum(Class<? extends LtForum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.host = inits.isInitialized("host") ? new QUser(forProperty("host")) : null;
    }

}

