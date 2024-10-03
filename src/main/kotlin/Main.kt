fun main() {
    var garage = Garage()
    var car = Voiture("Mercedes", 2014, "Noir", 5)
    var bike = Moto("Harley-Davidson", 1972, "Orange", true)
    var truck = Camion("Ford", 2000, "Blanc", 77)
    garage.ajouterVehicule(car)
    garage.ajouterVehicule(bike)
    garage.ajouterVehicule(truck)
    garage.afficherGarage()
}

class Garage{
    var listeVehicule = mutableListOf<Vehicule>()
    fun ajouterVehicule(vehicule: Vehicule){
        listeVehicule.add(vehicule)
    }
    fun afficherGarage(){
        for (i in 1..listeVehicule.size){
            listeVehicule[i-1].afficherDetails()
            listeVehicule[i-1].klaxonner()
        }
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
    override fun klaxonner() { println("Vroum") }
}
class Moto(override var marque: String, override var annee: Int, override var couleur: String, var sidecar: Boolean) : Vehicule(marque, annee, couleur) {
    override fun afficherDetails()
    {
        if (sidecar) println("Marque: $marque, Couleur: $couleur, Année: $annee, Sidecar: oui")
        else println("Marque: $marque, Couleur: $couleur, Année: $annee, Sidecar: non")
    }
    override fun klaxonner() { println("Blarg") }
}

/*class Voiture(var marque: String, var modele: String, var annee: Int): Vehicule{
    fun afficherVehicules(){
        println("Vroum!")
    }
    fun klaxon(){
        println("Honk!")
    }
}*/
/*class Voiture{
    var marque = ""
    var modele = ""
    var annee = 2000
}*/