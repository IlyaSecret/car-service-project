import "./gallery.scss";

export default function Gallery() {
    return (
        <div className="gallery">
            <p className="title">Галлерея</p>
            <div className="gallery__images">
                <img src="./img/gallery/img1.png"></img>
                <img src="./img/gallery/img2.png"></img>
                <img src="./img/gallery/img3.png"></img>
                <img src="./img/gallery/img4.png"></img>
                <img src="./img/gallery/img5.png"></img>
                <img src="./img/gallery/img6.png"></img>
            </div>
        </div>
    )
}