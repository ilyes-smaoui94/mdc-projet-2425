import java.util.Set;
import java.util.HashSet;

public class Reservation {
  private static int nextAvailableId = 1;
  private int id;
  private Set<Billet> billetsReservation;
  private Utilisateur utilisateurResa;

  public Reservation (Utilisateur u) {
    this.id = this.getNextAvailableId();
    this.utilisateurResa = u;
    this.billetsReservation = new HashSet<Billet>();
  }

  public Reservation (Utilisateur u, Set<Billet> billetsResa) {
    this.id = this.getNextAvailableId();
    this.utilisateurResa = u;
    if (billetsResa == null) {
      this.billetsReservation = new HashSet<Billet>();
    }
    else {
      this.billetsReservation = new HashSet<Billet>();
      // On ignore simplement les élements de billetsResa à valeur nulle
      for (Billet b : billetsResa) {
        if (b != null) {
          this.billetsReservation.add(b);
        }
      }
    }
  }

  protected int getNextAvailableId () {
    int nextID = Reservation.nextAvailableId;
    Reservation.nextAvailableId += 1;
    return nextID;
  }

  public int getId () {
    return this.id;
  }

  public void addBillet (Billet b) {
    if (b != null) {
      this.billetsReservation.add(b);
    }
  }

  public Set<Billet> getBillets () {
    return this.billetsReservation;
  }

  public double getPrixTotal () {
    double prixFinal = 0;
    for (Billet b : this.billetsReservation) {
      prixFinal += b.getPrix();
    }
    return prixFinal;
  }
}