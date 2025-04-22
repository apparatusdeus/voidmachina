package uk.isohex.voidmachina.api.energy;

public class VoidEnergyStorage {
  private int capacity;
  private int stored;

  public VoidEnergyStorage(int capacity) {
    this.capacity = capacity;
    this.stored = 0;
  }

  public int getStored() {
    return stored;
  }

  public int getCapacity() {
    return capacity;
  }

  public int receive(int amount) {
    int received = Math.min(amount, capacity - stored);
    stored += received;
    return received;
  }

  public int extract(int amount) {
    int extracted = Math.min(amount, stored);
    stored -= extracted;
    return extracted;
  }
}
