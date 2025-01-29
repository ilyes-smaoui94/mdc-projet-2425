class Planning {
  private static Planning planningUnique;
  
  private Planning () {}

  public static getInstance () {
    if (this.planningUnique == null) {
      this.planningUnique = new Planning();
    }
    else {
      System.err.println("Attention, un planning existe déjà !");
      System.err.println("Il ne peut pas y avoir de doublon !");
    }
    return this.planningUnique;
  }
}