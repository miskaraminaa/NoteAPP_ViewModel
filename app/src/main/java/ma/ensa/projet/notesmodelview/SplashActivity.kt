package ma.ensa.projet.notesmodelview

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Référence au TextView
        val splashText = findViewById<TextView>(R.id.splash_text)
        splashText.text = "Bienvenue dans NoteApp" // Modifier le texte selon ton app

        // Référence à l'ImageView
        val splashImage = findViewById<ImageView>(R.id.splash_image)

        // Délai avant de faire disparaître le texte et l'image
        Handler(Looper.getMainLooper()).postDelayed({
            // Animation de disparition pour le texte
            val fadeOutText = AlphaAnimation(1.0f, 0.0f).apply {
                duration = 2000 // 1 seconde pour l'animation de disparition
                fillAfter = true // Garder l'état final après l'animation
            }
            splashText.startAnimation(fadeOutText) // Démarrer l'animation de disparition du texte

            // Animation de disparition pour l'image
            val fadeOutImage = AlphaAnimation(1.0f, 0.0f).apply {
                duration = 2000 // 1 seconde pour l'animation de disparition
                fillAfter = true // Garder l'état final après l'animation
            }
            splashImage.startAnimation(fadeOutImage) // Démarrer l'animation de disparition de l'image

            // Délai pour s'assurer que les animations de disparition sont terminées avant de démarrer MainActivity
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 1000) // Délai de 1 seconde pour s'assurer que les animations de disparition sont terminées
        }, 1000) // Délai de 3 secondes avant de démarrer les animations de disparition
    }
}
