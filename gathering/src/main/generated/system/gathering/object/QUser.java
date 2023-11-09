package system.gathering.object;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1239014228L;

    public static final QUser user = new QUser("user");

    public final StringPath address = createString("address");

    public final StringPath detailAddress = createString("detailAddress");

    public final StringPath email = createString("email");

    public final StringPath extraAddress = createString("extraAddress");

    public final NumberPath<Long> grade = createNumber("grade", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath postcode = createString("postcode");

    public final StringPath recentGathering = createString("recentGathering");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final StringPath storeFile = createString("storeFile");

    public final StringPath uploadFile = createString("uploadFile");

    public final StringPath userId = createString("userId");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

