package Reasoner;

import java.io.File;
import java.util.Iterator;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.PrintUtil;
import org.apache.jena.vocabulary.ReasonerVocabulary;

public class InferenceScraper {
    private InfModel inference;
    private final Reasoner reasoner;

    public InferenceScraper() {
        LogCtl.setCmdLogging();
        reasoner = ReasonerRegistry.getRDFSReasoner();
        reasoner.setParameter(ReasonerVocabulary.PROPsetRDFSLevel, 
                ReasonerVocabulary.RDFS_SIMPLE);
    }

    public void setFiles(File fileSchema, File fileData){
        Model schema    = RDFDataMgr.loadModel(fileSchema.getAbsolutePath());
        Model data      = RDFDataMgr.loadModel(fileData.getAbsolutePath());
        reasoner.bindSchema(schema);
        this.inference = ModelFactory.createInfModel(reasoner, data);
    }
    
    public String getInference(){
        String result     = "";
        StmtIterator iter = inference.listStatements();
        while (iter.hasNext()) {
            Statement next = iter.next();
            result        += PrintUtil.print(next) + "\n";
        }
        return result;
    }
    
    public String getViolations(){
        String result             = "";
        ValidityReport validation = inference.validate();
        System.out.println(validation.isValid());
        Iterator iter             = validation.getReports();
        while (iter.hasNext()) {
            result += iter.next() + "\n";
        }
        return result;
    }
}
