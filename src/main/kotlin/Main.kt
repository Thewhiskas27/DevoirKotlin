@file:Suppress("SpellCheckingInspection") // Cette ligne permet à mon IDE de ne pas prendre en compte les "fautes de frappe"

fun main() {
    val garage = Garage() // Initialisation d'un garage
    val car = Voiture("Mercedes", 2014, "Noir", 5) // Initialisation d'une voiture
    val bike = Moto("Harley-Davidson", 1972, "Orange", true) // Initialisation d'une moto
    val truck = Camion("Ford", 2000, "Blanc", 77) // Initialisation d'un camion
    garage.ajouterVehicule(car) // On ajoute la voiture au garage
    garage.ajouterVehicule(bike) // On ajoute la moto au garage
    garage.ajouterVehicule(truck) // On ajoute le camion au garage
    garage.afficherGarage() // On affiche les détails de chaque véhicule
    garage.afficherNGarage() // On affiche le nombre de véhicules
    garage.afficherGarage(0) // On affiche les détails du premier véhicule inseré. Dans ce cas, la voiture
    garage.klaxonner(0) // On fait klaxxoner le 1r vehicule inseré. Dans ce cas, la voiture
    garage.afficherGarage(-1) // On affiche les détails du 4e véhicule inseré. Valeur négative donc le programme devra renvoyer "Véhicule non valide"
    garage.klaxonner(3) // On fait klaxxoner le 4e vehicule inseré. Il n'existe pas donc le programme devra renvoyer "Véhicule non valide"
    garage.retirerDuGarage() // On retire le dernier vehicule ajouté. Dans ce cas, le camion
    garage.retirerDuGarage(0) // On retire le 1r vehicule ajouté. Dans ce cas, la voiture
    garage.afficherGarage()
    garage.ajouterVehicule(car) // On ajoute la moto au garage
    garage.ajouterVehicule(truck) // On ajoute le camion au garage
    garage.afficherGarage()
}

class Garage{
    private var listeVehicule = mutableListOf<Vehicule>() // En effet, un garage est une liste de véhicules. Ici on l'a initialisée vide
    fun ajouterVehicule(vehicule: Vehicule){ // Fonction pour rajouter un véhicule
        listeVehicule.add(vehicule) // On rajoute le véhicule
    }
    fun afficherNGarage(){ // Affiche le nombre de Véhicules (N = Nombre)
        when(listeVehicule.size){ // On regarde le nombre de véhicules dans le garage
            0 -> println("Le garage ne contient aucun véhicule") // Si le nombre est 0, on affiche ceci
            1 -> println("Le garage contient 1 véhicule") // Si le nombre est 1, on l'affiche comme ceci
            else -> println("Le garage contient ${listeVehicule.size} véhicules") // Sinon, on l'affiche normalement
        }
    }
    fun afficherGarage(){ // Affiche tous les véhicules en ordre d'ajout
        for (i in 1..listeVehicule.size)
        {
            print("Véhicule #$i - ")
            listeVehicule[i-1].afficherDetails()
        } // Boucle affichant chaque véhicule.
    }
    fun afficherGarage(index: Int){ // Affiche un véhicule en spécifique (Surcharge permettant de mettre un nombre)
        if(index < 0 || index >= listeVehicule.size){ println("Vehicule non valide") } // Si on met un nombre négatif ou supérieur au nombre des véhicules dans le garage, rejeter
        else listeVehicule[index].afficherDetails() // Sinon, afficher les détails
    }
    fun klaxonner(index: Int){ // Klaxonne un véhicule en spécifique
        if(index < 0 || index >= listeVehicule.size){ println("Vehicule non valide") }
        else listeVehicule[index].klaxonner()
    }
    fun retirerDuGarage(){ // On enlève le dernier véhicule inseré
        listeVehicule.removeLast()
    }
    fun retirerDuGarage(index: Int){ // On enlève un véhicule en spécifique du garage
        if(index < 0 || index >= listeVehicule.size){ println("Vehicule non valide") }
        else listeVehicule.removeAt(index)
    }
}
abstract class Vehicule(open var marque: String, open var annee: Int, open var couleur: String){
    abstract fun afficherDetails()
    abstract fun klaxonner()
}

class Voiture(override var marque: String, override var annee: Int, override var couleur: String, var portes: Int) : Vehicule(marque, annee, couleur) {
    override fun afficherDetails() { println("Marque: $marque, Couleur: $couleur, Année: $annee, Nombre de portes: $portes") }
    override fun klaxonner() { println("Honk") }
}
class Camion(override var marque: String, override var annee: Int, override var couleur: String, var load: Int) : Vehicule(marque, annee, couleur) {
    override fun afficherDetails() { println("Marque: $marque, Couleur: $couleur, Année: $annee, Capacité de chargement: $load") }
    override fun klaxonner() { println("Blarg") }
}
class Moto(override var marque: String, override var annee: Int, override var couleur: String, var sidecar: Boolean) : Vehicule(marque, annee, couleur) {
    override fun afficherDetails()
    {
        if (sidecar) println("Marque: $marque, Couleur: $couleur, Année: $annee, Sidecar: oui")
        else println("Marque: $marque, Couleur: $couleur, Année: $annee, Sidecar: non")
    }
    override fun klaxonner() { println("Beep") }
}

