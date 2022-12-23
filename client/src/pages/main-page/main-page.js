import Header from "../../components/header/header";
import SignInForm from "../../components/sign-in-form/sign-in-form";
import Footer from "../../components/footer/footer";
import Comments from "../../components/comments/comments";
import Gallery from "../../components/gallery/gallery";
import Contacts from "../../components/contacts/contacts";
import BestSides from "../../components/best-sides/best-sides";
import Services from "../../components/services/services";
import AboutUs from "../../components/about-us/about-us";

export default function MainPage() {
    return (
        <div className="main-page">
            <Header />
            <SignInForm />
            <AboutUs />
            <Services />
            <BestSides />
            <Contacts />
            <Gallery />
            <Comments />
            <Footer />
        </div>
    )
}
