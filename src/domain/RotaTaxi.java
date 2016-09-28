package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class RotaTaxi implements Serializable {

	private long id;
	private long idTaxi;
	private Timestamp dataHora;
	private double latitude;
	private double longitude;
	
	public RotaTaxi(long id, long idTaxi, Timestamp dataHora, double latitude, double longitude) {
		super();
		this.id = id;
		this.idTaxi = idTaxi;
		this.dataHora = dataHora;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public RotaTaxi(long idTaxi, Timestamp dataHora, double latitude, double longitude) {
		super();
		this.idTaxi = idTaxi;
		this.dataHora = dataHora;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public RotaTaxi() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdTaxi() {
		return idTaxi;
	}

	public void setIdTaxi(long idTaxi) {
		this.idTaxi = idTaxi;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "RotaTaxi [id=" + id + ", idTaxi=" + idTaxi + ", dataHora=" + dataHora + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}	
	
}
