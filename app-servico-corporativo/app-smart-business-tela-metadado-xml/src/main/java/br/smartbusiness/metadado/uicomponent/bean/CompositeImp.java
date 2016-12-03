package br.smartbusiness.metadado.uicomponent.bean;

public class CompositeImp implements IComposite {

	private ICompositeInterfaces intefaces;
	private ICompositeImplentation implementacao;

	public CompositeImp(ICompositeInterfaces intefaces, ICompositeImplentation implementacao) {

		this.intefaces = intefaces;
		this.implementacao = implementacao;
	}

	@Override
	public ICompositeInterfaces getInterfaces() {
		
		if(this.intefaces!=null){
			return intefaces;
		}
	
		return null;
	}

	@Override
	public ICompositeImplentation getImpletation() {
		// TODO Auto-generated method stub
		return implementacao;
	}

}
