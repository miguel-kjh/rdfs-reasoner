package Reasoner;

import java.io.File;

public class InferenceResonator {
    private File schema;
    private File data;

    public void setFiles(File schema, File data){
        this.schema = schema;
        this.data   = data;
    }
    
    public String getInference(){
        return "Inferencia";
    }
    
    public String getViolations(){
        return "Violations";
    }
}
