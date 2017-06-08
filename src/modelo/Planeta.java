package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Planeta extends ElementoDelJuego {
	private static int cantidadPlanetas = 0;
	private  int tpt=5;
	private  int tpcnb=5;
	private  int tpcnd=5;
	private  int tpcntc=5;
	private int tpmp=20;
	private int tpva=3;
	public static int GetCantidadPlanetas(){
		return Planeta.cantidadPlanetas;
	}
	protected int poblacion;
	protected String nombre;
	protected String atacado;
	protected int cantidadTorretas;
	protected int cantidadNaveB;
	protected int cantidadNaveD;
	protected int cantidadNaveTC;
	protected int cantTurnosTor = tpt;
	protected int cantTurnosNB = tpcnb;
	protected int cantTurnosND = tpcnd;
	protected int cantTurnosNTC = tpcntc;
	protected int cantTurnosMP = tpmp;
	protected int cantTurnosVA= tpva;
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
	
	public Planeta(String nombre){
		this.poblacion=2;
		Planeta.cantidadPlanetas= Planeta.cantidadPlanetas+1;
		this.nombre=nombre;
		lnavesB = new ArrayList<NaveEspacial>();
		lnavesD = new ArrayList<NaveEspacial>();
		lnavesTC = new ArrayList<NaveEspacial>();
	}
	
	public int getCantidadTorretas() {
		return this.cantidadTorretas;
	}
	public void construirTorretas(){
		this.construyendoTorretas = true;
	}
	public int getCantidadNaveB(){
		return this.cantidadNaveB;
	}
	public int getCantidadNaveD(){
		return this.cantidadNaveD;
	}
	public int getCantidadNaveTC(){
		return this.cantidadNaveTC;
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
	public void viajarAtacar(Planeta planeta){
		enViajeDeAtaque = true;
		this.atacado=planeta.nombre;
		
	}
	
	
	public void avanzarTurno() {
		// TODO Auto-generated method stub
		super.avanzarTurno();
		if(this.enViajeDeAtaque){
			if(cantTurnosVA==0){
				for(NaveEspacial nav: lnavesB){
					nav.atacarNave();
				}
			}
		}
		if(this.construyendoTorretas){
			if(cantTurnosTor==0){
				this.cantidadTorretas = this.cantidadTorretas + 1;
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
				this.cantidadNaveB = this.cantidadNaveB + 1;
				NaveEspacial nav = new NaveB();
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
				this.cantidadNaveD = this.cantidadNaveD + 1;
				NaveEspacial nav = new NaveD();
				this.lnavesD.add(nav);
				this.construyendoNaveD=false;
				this.cantTurnosND=tpcnd;
			}else{
				this.cantTurnosND--;
			}
		}
		if(this.construyendoNaveTC){
			if(cantTurnosNTC==0){
				this.cantidadNaveTC = this.cantidadNaveTC + 1;
				NaveEspacial nav = new NaveTC();
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
	
	

}