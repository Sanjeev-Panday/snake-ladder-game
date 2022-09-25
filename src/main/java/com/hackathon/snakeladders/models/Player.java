package com.hackathon.snakeladders.models;

public class Player {
    private Color color;
    private PlayerType type;
    private int position;
    private PlayerStatus status;
    private Player(PlayerType type,int position, Color color) {
        this.type = type;
        this.position = position;
        this.color = color;
        this.status = PlayerStatus.WAITING;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

    @Override
    public String toString() {
        return String.format("Player color = %s , " +
                "Position on board = %d, " +
                "Player status = %s",
                this.color.name(), this.position, this.status);
    }

    public static class Builder {
        private Color color;
        private PlayerType type;

        private Builder(PlayerType type) {
            this.type = type;
        }
        public static Builder createBuilder(PlayerType type) {
            return new Builder(type);
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }
        public Player build() {
            return new Player(type,0, color);
        }
    }
}
