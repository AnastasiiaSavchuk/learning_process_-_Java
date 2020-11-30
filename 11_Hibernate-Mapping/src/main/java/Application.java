import model.Comment;
import model.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.UtilSessionFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        Session session = UtilSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        Comment comment1 = new Comment("Anastasiia Savchuk");
        Comment comment2 = new Comment("Dmytro Savchuk");

        Post post1 = new Post("lalalalalallalala", comment1);
        Post post2 = new Post("lililililililili", comment2);
        Post post3 = new Post("bebbebebebebe", comment1);
        Post post4 = new Post("aaaaaaaaaa", comment2);

        Set<Post> set1 = new HashSet<>(Arrays.asList(post1, post3));
        comment1.setPosts(set1);
        Set<Post> set2 = new HashSet<>(Arrays.asList(post2, post4));
        comment2.setPosts(set2);

        session.save(comment1);
        session.save(comment2);

        transaction.commit();
        session.close();
    }
}