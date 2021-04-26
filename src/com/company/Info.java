package com.company;

public class Info {
  private String name;
  private String place;
  private Integer height;

  public Info(String name, String place, Integer height) {
      this.name = name;
      this.place = place;
      this.height = height;
  }
    public Info() {
        this("", "", 0);
    }
   public String GetName(){
      return name;
   }
   public String GetPlace(){
      return place;
   }
   public Integer GetHeight(){
      return height;
   }

   public void SetName(String newName){
      this.name = newName;
   }
   public void SetPlace(String newPlace){
      this.place = newPlace;
   }
   public void SetHeight(Integer newHeight) {
      this.height = newHeight;
   }

   public String toString() {
      return name + " " + place + " " + height;
   }
}
