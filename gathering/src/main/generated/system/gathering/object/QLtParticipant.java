package system.gathering.object;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLtParticipant is a Querydsl query type for LtParticipant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLtParticipant extends EntityPathBase<LtParticipant> {

    private static final long serialVersionUID = 1702149922L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLtParticipant ltParticipant = new QLtParticipant("ltParticipant");

    public final NumberPath<Long> forumId = createNumber("forumId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QLtParticipant(String variable) {
        this(LtParticipant.class, forVariable(variable), INITS);
    }

    public QLtParticipant(Path<? extends LtParticipant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLtParticipant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLtParticipant(PathMetadata metadata, PathInits inits) {
        this(LtParticipant.class, metadata, inits);
    }

    public QLtParticipant(Class<? extends LtParticipant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

