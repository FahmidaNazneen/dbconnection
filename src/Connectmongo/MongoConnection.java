package Connectmongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoConnection {

    public static MongoDatabase mongoDatabase = null;
    public static MongoDatabase connectToMongoDB(){
        MongoClient mongoClient = new MongoClient();
        mongoDatabase = mongoClient.getDatabase("Students");
        System.out.println("Database Connected");

        return mongoDatabase;
    }
    public static String insertToMongoDB(User user){
        String profile = user.getStName();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
        Document document = new Document().append("stName",user.getStName()).append("stID",user.getStTD()).append("stDOB",user.getStDOB());
        collection.insertOne(document);
        return profile + " has been registerd";

        }
        public static List<User> readFromMongoDB(){
        List<User> list = new ArrayList<User>();
        User user = new User();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
        BasicDBObject basicDBObject = new BasicDBObject();
        FindIterable<Document> iterable = collection.find(basicDBObject);
        for (Document doc:iterable){
            String id = "";
            int idInt = 0;
            String stName = (String)doc.get("stName");
            user.setStName(stName);
            String stID = (String)doc.get("stID");
            user.setStTD(stID);
            String stDOB = (String)doc.get("stDOB");
            user.setStDOB(stDOB);
            user = new User( stName, stID, stDOB);
            list.add(user);

        }
        return  list;

        }

    public static void main(String[] args)throws Exception {
        insertToMongoDB(new User( "Fahmida", "109","10-08-1992"));
        List<User>user = readFromMongoDB()
;
    for (User person:user){
        System.out.println(person.getStName()+" "+person.getStTD());

    }
    }

    }
