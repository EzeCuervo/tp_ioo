package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Planeta extends ElementoDelJuego {
	private static int cantidadPlanetas = 0;
	private  int tpt=5;
	private  int tpcnb=1;
	private  int tpcnd=5;
	private  int tpcntc=1;
	private int tpmp=20;
	private int tpva=3;
	private int tpvc=2;
	protected int poblacion;
	protected String nombre;
	protected int idOwner;
	protected int idPlaneta;
	protected int cantidadTorretas;
	protected int cantTurnosTor = tpt;
	protected int cantTurnosNB = tpcnb;
	protected int cantTurnosND = tpcnd;
	protected int cantTurnosNTC = tpcntc;
	protected int cantTurnosMP = tpmp;
	protected int cantTurnosVA = tpva;
	protected int cantTurnosVC = tpvc;
	private List<NaveEspacial> lnavesB = new ArrayList<NaveEspacial>();
	private List<NaveEspacial> lnavesD = new ArrayList<NaveEspacial>();
	private List<NaveEspacial> lnavesTC = new ArrayList<NaveEspacial>();
	private List<Torreta> ltorretas = new ArrayList<Torreta>();
	protected boolean construyendoTorretas = false;
	protected boolean construyendoNaveB = false;
	protected boolean construyendoNaveD = false;
	protected boolean construyendoNaveTC = false;
	protected boolean mejorandoProduccion = false;
	protected boolean enViajeDeAtaque = false;
	protected boolean enViajeAColonizar = false;
	
	public Planeta(String nombre){
		this.idOwner=-1;
		this.poblacion=0;
		this.idPlaneta=cantidadPlanetas;
		Planeta.cantidadPlanetas= Planeta.cantidadPlanetas+1;
		this.nombre=nombre;
		lnavesB = new ArrayList<NaveEspacial>();
		lnavesD = new ArrayList<NaveEspacial>();
		lnavesTC = new ArrayList<NaveEspacial>();
	}
	public static int GetCantidadPlanetas(){
		return Planeta.cantidadPlanetas;
	}
	
	public int getCantidadTorretas() {
		return this.cantidadTorretas;
	}
	public void construirTorretas(){
		this.construyendoTorretas = true;
	}
	public void prodNaveB(){
		this.construyendoNaveB = true;
	}
	public void prodNaveD(){
		this.construyendoNaveD = true;
	}
	public void prodNaveTC(){
		this.construyendoNaveTC = true;
	}
	public void mejorarPlaneta(){
		this.mejorandoProduccion = true;
		
	}

	public void avanzarTurno() {
		// TODO Auto-generated method stub
		super.avanzarTurno();
		if(this.construyendoTorretas){
			if(cantTurnosTor==0){
				Torreta tor = new Torreta();
				this.ltorretas.add(tor);
				this.construyendoTorretas=false;
				this.cantTurnosTor=tpt;
			}else{
				this.cantTurnosTor--;
			}
			
		}
		if(this.construyendoNaveB){
			if(cantTurnosNB==0){
				NaveEspacial nav = new NaveB(getIdOwner(), getIdPlaneta());
				this.lnavesB.add(nav);
				this.construyendoNaveB=false;
				this.cantTurnosNB=tpcnb;
			}else{
				this.cantTurnosNB--;
			}
		}
		if(this.mejorandoProduccion){
			if(cantTurnosMP==0){
				this.tpt= tpt - 1;
				this.tpcnb=tpcnb - 1;
				this.tpcnd= tpcnd - 1;
				this.tpcntc= tpcnd - 1;
				this.cantTurnosTor = tpt;
				this.cantTurnosNB = tpcnb;
				this.cantTurnosND = tpcnd;
				this.cantTurnosNTC = tpcntc;
				this.construyendoNaveB=false;
				this.cantTurnosMP=tpmp;
			}else{
				this.cantTurnosMP--;
			}
		}
		if(this.construyendoNaveD){
			if(cantTurnosND==0){
				NaveEspacial nav = new NaveD(getIdOwner(), getIdPlaneta());
				this.lnavesD.add(nav);
				this.construyendoNaveD=false;
				this.cantTurnosND=tpcnd;
			}else{
				this.cantTurnosND--;
			}
		}
		if(this.construyendoNaveTC){
			if(cantTurnosNTC==0){
				NaveEspacial nav = new NaveTC(getIdOwner(), getIdPlaneta());
				this.lnavesTC.add(nav);
				this.construyendoNaveTC=false;
				this.cantTurnosNTC=tpcntc;
			}else{
				this.cantTurnosNTC--;
			}
		}
		
	}
	
	public int getPoblacion() {
		return this.poblacion;
	}
	public String getNombre(){
		return this.nombre;
	}
	
	public List<NaveEspacial> getLnavesB() {
		return lnavesB;
	}
	public void setLnavesB(List<NaveEspacial> lnavesB) {
		this.lnavesB = lnavesB;
	}
	public List<NaveEspacial> getLnavesD() {
		return lnavesD;
	}
	public void setLnavesD(List<NaveEspacial> lnavesD) {
		this.lnavesD = lnavesD;
	}
	public List<NaveEspacial> getLnavesTC() {
		return lnavesTC;
	}
	public void setLnavesTC(List<NaveEspacial> lnavesTC) {
		this.lnavesTC = lnavesTC;
	}
	public List<Torreta> getLtorretas() {
		return ltorretas;
	}
	public void setLtorretas(List<Torreta> ltorretas) {
		this.ltorretas = ltorretas;
	}
	public int getIdOwner() {
		return idOwner;
	}
	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}
	public int getIdPlaneta() {
		return idPlaneta;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	public NaveTC getNaveTC(){
		return (NaveTC) lnavesTC.get(0);
		
	}

}
