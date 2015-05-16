package compiler.interpret;

import java.util.ArrayList;

/**
 * Created by Lasse on 15-05-2015.
 */
public class FunctionInfo {
    private Type returnType;
    private ArrayList<Type> parameters;

    public FunctionInfo(Type type, ArrayList<Type> paramTypes){
        this.returnType = type;
        this.parameters = paramTypes;
    }

    public ArrayList<Type> GetParameters(){
        return new ArrayList<Type>(parameters);
    }

    public boolean Equals(FunctionInfo func){
        if (this.parameters.size() != func.GetParameters().size()){
            return false;
        }
        for (int i = 0; i < parameters.size(); i++){
            if (this.parameters.get(i) != func.GetParameters().get(i))
                return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Returntype: " + returnType + " - Paramtypes: " + parameters.toString();
    }
}
