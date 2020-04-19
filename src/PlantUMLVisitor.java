import java.io.PrintStream;
import java.util.ArrayList;

import padl.kernel.IAbstractModel;
import padl.kernel.IAggregation;
import padl.kernel.IAssociation;
import padl.kernel.IClass;
import padl.kernel.IComposition;
import padl.kernel.IConstituent;
import padl.kernel.IConstructor;
import padl.kernel.IContainerAggregation;
import padl.kernel.IContainerComposition;
import padl.kernel.ICreation;
import padl.kernel.IDelegatingMethod;
import padl.kernel.IField;
import padl.kernel.IGetter;
import padl.kernel.IGhost;
import padl.kernel.IInterface;
import padl.kernel.IMemberClass;
import padl.kernel.IMemberGhost;
import padl.kernel.IMemberInterface;
import padl.kernel.IMethod;
import padl.kernel.IMethodInvocation;
import padl.kernel.IPackage;
import padl.kernel.IPackageDefault;
import padl.kernel.IParameter;
import padl.kernel.IPrimitiveEntity;
import padl.kernel.ISetter;
import padl.kernel.IUseRelationship;
import padl.visitor.IWalker;

public class PlantUMLVisitor implements IWalker {

	public static PrintStream printobj = null;

	private ArrayList<String> associationList;
	private ArrayList<String> aggregationList;
	private ArrayList<String> compositionList;

	@Override
	public void close(IAbstractModel anAbstractModel) {
		// TODO Auto-generated method stub
		printobj.println("@enduml");
	}

	@Override
	public void close(IClass aClass) {
		// TODO Auto-generated method stub
		for (String a : associationList) {
			printobj.println("\r\n" + aClass.getDisplayID() + " -- " + a);
		}

		for (String ag : aggregationList) {
			printobj.println("\r\n" + aClass.getDisplayID() + " o-- " + ag);
		}

		for (String c : compositionList) {
			printobj.println("\r\n" + aClass.getDisplayID() + " *-- " + c);
		}
	}

	@Override
	public void close(IConstructor aConstructor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IDelegatingMethod aDelegatingMethod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IGetter aGetter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IGhost aGhost) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IInterface anInterface) {
		// TODO Auto-generated method stub

		for (String a : associationList) {
			printobj.println("\r\n" + anInterface.getDisplayID() + " -- " + a);
		}

		for (String ag : aggregationList) {
			printobj.println("\r\n" + anInterface.getDisplayID() + " o-- " + ag);
		}

		for (String c : compositionList) {
			printobj.println("\r\n" + anInterface.getDisplayID() + " *-- " + c);
		}
	}

	@Override
	public void close(IMemberClass aMemberClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IMemberGhost aMemberGhost) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IMemberInterface aMemberInterface) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IMethod aMethod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IPackage aPackage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(IPackageDefault aPackage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close(ISetter aSetter) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void open(IAbstractModel anAbstractModel) {
		printobj.println("@startuml");
	}

	@Override
	public void open(IClass aClass) {
		// TODO Auto-generated method stub
		this.associationList = new ArrayList<>();
		this.aggregationList = new ArrayList<>();
		this.compositionList = new ArrayList<>();

	}

	@Override
	public void open(IConstructor aConstructor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IDelegatingMethod aDelegatingMethod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IGetter aGetter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IGhost aGhost) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IInterface anInterface) {
		this.associationList = new ArrayList<>();
		this.aggregationList = new ArrayList<>();
		this.compositionList = new ArrayList<>();
	}

	@Override
	public void open(IMemberClass aMemberClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IMemberGhost aMemberGhost) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IMemberInterface aMemberInterface) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IMethod aMethod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IPackage aPackage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(IPackageDefault aPackage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open(ISetter aSetter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unknownConstituentHandler(String aCalledMethodName, IConstituent aConstituent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IAggregation anAggregation) {
		aggregationList.add(anAggregation.getTargetEntity().getDisplayID());
	}

	@Override
	public void visit(IAssociation anAssociation) {
		associationList.add(anAssociation.getTargetEntity().getDisplayID());
	}

	@Override
	public void visit(IComposition aComposition) {
		compositionList.add(aComposition.getTargetEntity().getDisplayID());
	}

	@Override
	public void visit(IContainerAggregation aContainerAggregation) {
		// TODO Auto-generated method stub
//		aggregationList.add(aContainerAggregation.getTargetEntity().getDisplayID());
	}

	@Override
	public void visit(IContainerComposition aContainerComposition) {
		// TODO Auto-generated method stub
//		compositionList.add(aContainerComposition.getTargetEntity().getDisplayID());
	}

	@Override
	public void visit(ICreation aCreation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IField aField) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IMethodInvocation aMethodInvocation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IParameter aParameter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IPrimitiveEntity aPrimitiveEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IUseRelationship aUse) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}