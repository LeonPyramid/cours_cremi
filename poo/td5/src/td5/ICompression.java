package td5;

interface ICompression {
    public String compress(String data);
    public String uncompress(String data) throws DecodeError;
}
