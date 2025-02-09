package com.example.programming

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
 var currImg=0
        lateinit var image:ImageView
        var NameArr= arrayOf(
            "Kotlin","C","C++","Java","Python","JavaScript","Swift","Go(Golang)","Rust","PHP","TypeScript","Ruby","R","Perl","Shell (Bash)")

        var CreatorArr=arrayOf("JetBrains","Dennis Ritchie","Bjarne Stroustrup","James Gosling","Guido van Rossum","Brendan Eich (Netscape)","Apple Inc","Google"," Mozilla ","Rasmus Lerdorf","Microsoft","Yukihiro Matsumoto","Ross Ihaka & Robert","Larry Wall","Brian Fox (GNU Project)")
        var DateArr=arrayOf("2011","1972","1983","1995","1991","1995","2014","2009","2010","1995","2012","1995","1993","1987","1989")

        val documentationUrl = arrayOf(
            "https://kotlinlang.org/docs/home.html",    // Kotlin
            "https://devdocs.io/c/",                     // C
            "https://cplusplus.com/doc/tutorial/",      // C++
            "https://docs.oracle.com/en/java/",         // Java
            "https://docs.python.org/3/",               // Python
            "https://developer.mozilla.org/en-US/docs/Web/JavaScript", // JavaScript
            "https://developer.apple.com/documentation/swift",  // Swift
            "https://go.dev/doc/",                      // Go (Golang)
            "https://doc.rust-lang.org/book/",          // Rust
            "https://www.php.net/docs.php",             // PHP
            "https://www.typescriptlang.org/docs/",     // TypeScript
            "https://ruby-doc.org/",                    // Ruby
            "https://cran.r-project.org/manuals.html",  // R
            "https://perldoc.perl.org/",                // Perl
            "https://www.gnu.org/software/bash/manual/", // Shell Scripting (Bash)
        )

        val used=arrayOf("Android development, server-side applications, cross-platform apps",
            "System programming, OS development (Linux, Windows), embedded systems",
            "Game development, high-performance applications, system software",
            "Enterprise applications, Android development, web servers",
            "AI, machine learning, data science, backend development",
            " Web development, frontend frameworks (React, Vue), backend (Node.js)",
            "iOS/macOS app development, server-side Swift",
            "Cloud computing, backend services, networking tools",
            "System programming, high-performance applications, game engines",
            "Web development, server-side scripting, CMS (WordPress, Joomla)",
            "Large-scale web applications, frontend frameworks (Angular, React)",
            "Web development, scripting, Rails framework",
            "Statistical computing, data science, machine learning",
            "Text processing, scripting, network programming",
            "Automating tasks in Unix/Linux, server management")


        val prevBtn = findViewById<ImageButton>(R.id.prev)
        val nextBtn = findViewById<ImageButton>(R.id.next)
        val btnView = findViewById<ImageView>(R.id.btnView)
        val heading=findViewById<TextView>(R.id.heading)
        val Founder=findViewById<TextView>(R.id.creator)
        val usedAt=findViewById<TextView>(R.id.usedIn)
        val createdDate=findViewById<TextView>(R.id.launchDate)

        btnView.setOnClickListener{
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse(documentationUrl[currImg]))
            startActivity(intent)
        }
        prevBtn.setOnClickListener{
            var idCurrImgStr="pic$currImg"
            var idCurrImgInt=this.resources.getIdentifier(idCurrImgStr,"id",packageName)
            image=findViewById(idCurrImgInt)
            image.alpha=0f
            currImg=(15+currImg-1)%15

            var idImgtoShowStr="pic$currImg"
            var idImgtoShowInt=this.resources.getIdentifier(idImgtoShowStr,"id",packageName)
            image=findViewById(idImgtoShowInt)
            image.alpha=1f
            heading.setText(NameArr[currImg])
            Founder.setText(CreatorArr[currImg])
            usedAt.setText(used[currImg])
            createdDate.setText(DateArr[currImg])

        }
        nextBtn.setOnClickListener{
            var idCurrImgStr="pic$currImg"
            var idCurrImgInt=this.resources.getIdentifier(idCurrImgStr,"id",packageName)
            image=findViewById(idCurrImgInt)
            image.alpha=0f
            currImg=(15+currImg+1)%15

            var idImgtoShowStr="pic$currImg"
            var idImgtoShowInt=this.resources.getIdentifier(idImgtoShowStr,"id",packageName)
            image=findViewById(idImgtoShowInt)
            image.alpha=1f
            heading.setText(NameArr[currImg])
            Founder.setText(CreatorArr[currImg])
            usedAt.setText(used[currImg])
            createdDate.setText(DateArr[currImg])
        }

    }
}