package system.gathering.object;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChatting is a Querydsl query type for Chatting
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatting extends EntityPathBase<Chatting> {

    private static final long serialVersionUID = 769228111L;

    public static final QChatting chatting = new QChatting("chatting");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QChatting(String variable) {
        super(Chatting.class, forVariable(variable));
    }

    public QChatting(Path<? extends Chatting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChatting(PathMetadata metadata) {
        super(Chatting.class, metadata);
    }

}

