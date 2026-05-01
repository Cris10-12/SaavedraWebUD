package co.edu.udistrital.CDT;

// Cristian David Peña Saavedra

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("cdt")
@ViewScoped
public class CDT implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final double ANIO = 360;

    private double inversion;
    private double interes;
    private double plazo;
    private double ganancia;
    private double valorFuturo;
    private double impuesto;

    public CDT() {
        super();
    }

    public void calcular() {
        ganancia    = inversion * (interes * (plazo / ANIO));
        valorFuturo = inversion + ganancia;
        impuesto    = ganancia * 0.04;
    }

    public double getInversion()  { return inversion;  }
    public void   setInversion(double inversion)  { this.inversion  = inversion;  }

    public double getInteres()    { return interes;    }
    public void   setInteres(double interes)      { this.interes    = interes;    }

    public double getPlazo()      { return plazo;      }
    public void   setPlazo(double plazo)          { this.plazo      = plazo;      }

    public double getGanancia()   { return ganancia;   }
    public void   setGanancia(double ganancia)    { this.ganancia   = ganancia;   }

    public double getValorFuturo(){ return valorFuturo;}
    public void   setValorFuturo(double valorFuturo)  { this.valorFuturo = valorFuturo; }

    public double getImpuesto()   { return impuesto;   }
}
