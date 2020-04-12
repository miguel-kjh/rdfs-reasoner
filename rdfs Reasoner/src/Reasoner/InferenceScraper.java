package Reasoner;

import java.io.File;
import java.util.Iterator;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
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
    private Reasoner reasoner;

    public InferenceScraper() {
        LogCtl.setCmdLogging();
        reasoner = ReasonerRegistry.getRDFSReasoner();
        reasoner.setParameter(ReasonerVocabulary.PROPsetRDFSLevel, 
                ReasonerVocabulary.RDFS_SIMPLE);
    }

    public void setFiles(File fileSchema, File fileData){
        Model schema    = RDFDataMgr.loadModel(fileSchema.getAbsolutePath());
        Model data      = RDFDataMgr.loadModel(fileData.getAbsolutePath());
        this.reasoner   = reasoner.bindSchema(schema);
        this.inference  = ModelFactory.createInfModel(reasoner, data);
    }
    
    public void clearReasoner(){
        reasoner = ReasonerRegistry.getRDFSReasoner();
        reasoner.setParameter(ReasonerVocabulary.PROPsetRDFSLevel, 
                ReasonerVocabulary.RDFS_SIMPLE);
    }
    
    public String getInference(){
        String result     = "";
        StmtIterator iter = inference.listStatements(
                null,
                inference.getProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
                (RDFNode)  null
        );
        while (iter.hasNext()) {
            Statement next = iter.next();
            result        += PrintUtil.print(next) + "\n";
        }
        return result;
    }
    
    public String getViolations(){
        String result             = "";
        ValidityReport validation = inference.validate();
        Iterator iter             = validation.getReports();
        while (iter.hasNext()) {
            result += iter.next() + "\n";
        }
        return result;
    }
}
