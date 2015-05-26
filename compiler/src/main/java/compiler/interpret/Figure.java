package compiler.interpret;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Lasse on 26-05-2015.
 */
public class Figure {
    private HashMap<String, Type> members = new HashMap<>();
    private HashMap<String, List<TypeExpression>> methods = new HashMap<>();

    public void AddMember(String key, Type type){
        members.put(key, type);
    }

    public void AddMethod(String key, List<TypeExpression> types){
        methods.put(key, types);
    }

    public boolean HasMember(String key){
        return members.containsKey(key);
    }

    public boolean HasMethod(String key){
        return methods.containsKey(key);
    }

    public List<TypeExpression> GetMethod(String key){
        return methods.get(key);
    }

    public Type GetMember(String key){
        return members.get(key);
    }

}
