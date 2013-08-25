package web.scripts

class Tag {
    String name
    static constraints = {
    }
    static mapping = {
        version false
        id generator: 'sequence', params: [sequence: "tag_seq"]
    }
}
