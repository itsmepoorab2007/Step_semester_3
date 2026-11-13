// PROBLEM 2 (Assignment): Gallery Description Cards
abstract class ArtPiece {
    private static int counter = 0;
    protected final String pieceId;
    protected String title;

    public ArtPiece(String title) {
        counter++;
        this.pieceId = "PIECE-" + counter;
        this.title = title;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    public Painting(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    public Sculpture(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class GalleryDescriptionCards {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        System.out.println(p.describe());

        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(s.describe());
    }
}
