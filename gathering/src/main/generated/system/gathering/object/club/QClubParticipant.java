package system.gathering.object.club;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClubParticipant is a Querydsl query type for ClubParticipant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClubParticipant extends EntityPathBase<ClubParticipant> {

    private static final long serialVersionUID = 1701878958L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClubParticipant clubParticipant = new QClubParticipant("clubParticipant");

    public final NumberPath<Long> clubId = createNumber("clubId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final system.gathering.object.QUser user;

    public final StringPath whether = createString("whether");

    public QClubParticipant(String variable) {
        this(ClubParticipant.class, forVariable(variable), INITS);
    }

    public QClubParticipant(Path<? extends ClubParticipant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClubParticipant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClubParticipant(PathMetadata metadata, PathInits inits) {
        this(ClubParticipant.class, metadata, inits);
    }

    public QClubParticipant(Class<? extends ClubParticipant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new system.gathering.object.QUser(forProperty("user")) : null;
    }

}

