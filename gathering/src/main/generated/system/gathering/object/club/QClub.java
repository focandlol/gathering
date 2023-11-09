package system.gathering.object.club;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = -1262326459L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClub club = new QClub("club");

    public final EnumPath<system.gathering.object.Category> category = createEnum("category", system.gathering.object.Category.class);

    public final NumberPath<Long> clubId = createNumber("clubId", Long.class);

    public final StringPath clubName = createString("clubName");

    public final system.gathering.object.QUser host;

    public final StringPath intro = createString("intro");

    public final StringPath storeFile = createString("storeFile");

    public final StringPath uploadFile = createString("uploadFile");

    public QClub(String variable) {
        this(Club.class, forVariable(variable), INITS);
    }

    public QClub(Path<? extends Club> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClub(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClub(PathMetadata metadata, PathInits inits) {
        this(Club.class, metadata, inits);
    }

    public QClub(Class<? extends Club> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.host = inits.isInitialized("host") ? new system.gathering.object.QUser(forProperty("host")) : null;
    }

}

