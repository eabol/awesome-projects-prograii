public interface Renderer {
    void renderGame(Game game);
    void close() throws Exception;
    void movePacman(Position previousPosition) throws Exception;
}